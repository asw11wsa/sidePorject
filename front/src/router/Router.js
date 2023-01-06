import React from 'react';
import { Route, Routes } from "react-router-dom";
import UserLayout from '../layout/UserLayout';
import UserLogin from '../pages/login/UserLogin';
import Main from '../pages/Main';

const Routers = () => {
    return(
        <Routes>
            <Route element={<UserLayout/>}>
                <Route path="/" element={<Main/>}/>
                <Route path="/login" element={<UserLogin/>} />
            </Route>
        </Routes>
    );
}

export default Routers;