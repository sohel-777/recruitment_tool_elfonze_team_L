import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./styles.css";

const Navbar = () => {
  const [isAdmin, setIsAdmin] = useState(true);

  const handleToggleAdmin = () => {
    setIsAdmin((prevIsAdmin) => !prevIsAdmin);
  };

  return (
    <nav>
      <ul>
        <li>
          <Link to="/">
            <h2>Recruitment-Tool</h2>
          </Link>
        </li>
        <li>
          <Link to="/login">Login</Link>
        </li>
        <li>
          {isAdmin ? (
            <Link to="/adminregister" onClick={handleToggleAdmin}>
              <p>Admin Register Here</p>
            </Link>
          ) : (
            <Link to="/register" onClick={handleToggleAdmin}>
              <p>User Register Here</p>
            </Link>
          )}
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
