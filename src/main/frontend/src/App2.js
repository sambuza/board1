import React from "react";
// import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Router, Routes, Route, Link } from "react-router-dom";
// import Home from "./Home";
import About from "./pages/about/About";
import Work from "./pages/work/Work";
import Post from "./pages/post/Post";
import Navigation from "./components/Navigation";
import Hero from "./components/Hero";
import "./styles.css"; // Import the CSS file

function App() {
  return (
    <div>
      <nav>
        <div className='logo'>
          {/* <img src='logo.png' alt='삼부자' /> */}sambuza
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
      <footer></footer>
    </div>
  );
}

export default App;
