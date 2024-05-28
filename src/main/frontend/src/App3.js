import { useNavigate } from "react-router-dom"; // useNavigate 훅을 임포트합니다.
import { Router, Routes, Route, Link } from "react-router-dom";
import About from "./pages/about/About";
import Work from "./pages/work/Work";
import Post from "./pages/post/Post";
import Navigation from "./components/Navigation";
import Hero from "./components/Hero";
import Footer from "./components/Footer";
import "./styles.css"; // Import the CSS file
import HeroImage01 from "./components/HeroImage01";
import HeroImage02 from "./components/HeroImage02";
import HeroImage03 from "./components/HeroImage03";
import HeroImage04 from "./components/HeroImage04";
import HeroMessage01 from "./components/HeroMessage01";

function App() {
  const navigate = useNavigate(); // useNavigate 훅을 사용하여 navigate 함수를 생성합니다.

  const handleLogoClick = () => {
    navigate("/"); // 루트 경로("/")로 이동합니다.
  };

  return (
    <div>
      <nav>
        <div className='logo' onClick={handleLogoClick}>
          {<img src='/imgs/1400600.png' alt='삼부자logo' />}
        </div>
        <Navigation />
      </nav>
      <main>
        <Routes>
          <Route path='/' element={<Hero />} />
          <Route path='/about' element={<About />}></Route>
          <Route path='/work' element={<Work />}></Route>
          <Route path='/post' element={<Post />}></Route>
        </Routes>
      </main>
      <footer>
        <Footer />
        {/* <div
          onClick={handleLogoClick}
          style={{
            cursor: "pointer",
            position: "absolute",
            top: "15PX",
            left: "220PX",
            margin: "10px",
          }}
        >
          sambuza
        </div> */}
      </footer>
    </div>
  );
}

export default App;
