import logo from './logo.svg';
import {idCheck,userLogin} from './axios/userApi'
import { BrowserRouter} from "react-router-dom"; 
import './App.css';
import Routers from "./router/Router";
import { useState } from 'react';

function App() {
  const [user, setUser] = useState({
    membId: "",
    membPwd: ""
  })

  const check = async(dto) => {
    let result = await userLogin(dto);
    console.log(result.data);
  }

  const idChecks = async(dto) => {
    let result = await idCheck(dto);
    console.log(result.data);
  }

  return (
    <BrowserRouter>
      <Routers/>
    </BrowserRouter>
  );
};

export default App;
