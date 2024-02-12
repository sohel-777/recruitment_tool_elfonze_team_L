import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom';

function Home() {
  const navigate = useNavigate();
  const token = localStorage.getItem("token") || null

  useEffect(() => {
    if (!token) {
      console.log(token)
      navigate("/login");
    }
  }, []);

  return (
    <div>
      Home
    </div>
  )
}

export default Home
