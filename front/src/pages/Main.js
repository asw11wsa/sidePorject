import React from 'react'
import { Link } from 'react-router-dom'

const Main = () => {
  return (
    <div>
        <div>Main</div>
        <Link to={"/login"}>login</Link>
    </div>
  )
}

export default Main