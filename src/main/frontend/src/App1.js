import React, { useState } from "react";
import axios from "axios";

function App() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault(); // 폼의 기본 제출 동작을 막습니다.
    const valuesList1 = [username, password];

    try {
      const response = await axios.post(
        "http://localhost:1088/user/login1",
        valuesList1,
        {
          withCredentials: true, // 세션 쿠키를 포함하기 위해 설정
        }
      );
      setMessage(response.data);
    } catch (error) {
      if (error.response) {
        setMessage(error.response.data);
      } else {
        setMessage("서버 오류가 발생했습니다.");
      }
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username:</label>
          <input type='text' value={username} onChange={handleUsernameChange} />
        </div>
        <div>
          <label>Password:</label>
          <input
            type='password'
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <button type='submit'>Check Credentials</button>
      </form>
      <p>{message}</p>
    </div>
  );
}

export default App;
