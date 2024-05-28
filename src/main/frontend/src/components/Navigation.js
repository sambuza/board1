import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./Navigation.css";

function Navigation() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };
  const toggleTest = () => {
    setIsOpen(isOpen);
  };

  return (
    <nav>
      <div className='menu-icon' onClick={toggleTest}>
        <Link to='/' onClick={() => setIsOpen(false)}>
          SamBuza
        </Link>
        &#9776;
      </div>

      <ul className={isOpen ? "nav-links open" : "nav-links"}>
        <li>
          <Link to='/about' onClick={() => setIsOpen(false)}>
            About
          </Link>
        </li>
        <li>
          <Link to='/work' onClick={() => setIsOpen(false)}>
            Works
          </Link>
        </li>
        <li>
          <Link to='/post' onClick={() => setIsOpen(false)}>
            Posts
          </Link>
        </li>
      </ul>
    </nav>
  );
}

export default Navigation;
