import React from "react";

const Footer = () => {
  return (
    <footer>
      <style>
        {`
 footer {
 background-color: #f8f9fa;
 padding: 50px 0;
 text-align: center;
 }
 
 .container {
 max-width: 1200px;
 margin: 0 auto;
 }
 
 .row {
 display: flex;
 justify-content: space-between;
 align-items: center;
 }
 
 .col-md-4 {
 padding: 0 20px;
 }
 
 h3 {
 font-size: 18px;
 font-weight: bold;
 margin-bottom: 10px;
 }
 
 p {
 font-size: 14px;
 line-height: 1.5;
 }
 
 ul {
 list-style: none;
 margin: 0;
 padding: 0;
 }
 
 li {
 display: inline-block;
 margin-right: 10px;
 }
 
 a {
 color: #333;
 text-decoration: none;
 }
 
 form {
 display: flex;
 align-items: center;
 }
 
 input[type="email"] {
 width: 200px;
 padding: 10px;
 border: 1px solid #ccc;
 border-radius: 3px;
 }
 
 button[type="submit"] {
 padding: 10px 20px;
 background-color: #007bff;
 color: #fff;
 border: none;
 border-radius: 3px;
 cursor: pointer;
 }
 `}
      </style>
      <div className='container'>
        <div className='row'>
          <div className='col-md-4'>
            <h3>Contact Us</h3>
            <p>주소: 서울특별시 강남구 역삼동 1234-56</p>
            <p>전화번호: 02-1234-5678</p>
          </div>
          <div className='col-md-4'>
            <h3>Follow Us</h3>
            <ul>
              <li>
                <a href='#'>Facebook</a>
              </li>
              <li>
                <a href='#'>Twitter</a>
              </li>
              <li>
                <a href='#'>Instagram</a>
              </li>
            </ul>
          </div>
          <div className='col-md-4'>
            <h3>Newsletter</h3>
            <form>
              <input type='email' placeholder='이메일 주소를 입력하세요' />
              <button type='submit'>구독하기</button>
            </form>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
