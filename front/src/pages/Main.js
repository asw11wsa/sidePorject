import React, { useState } from 'react'
import { myPoint } from '../axios/pointApi'
import { Link } from 'react-router-dom'

const Main = () => {
  const [point, setPoint] = useState({
    membSn: 4
  })

  const myPoints = async (dto) => {
    let result = await myPoint(dto);
    console.log(result);
  }

  return (
    <div>
        <div>Main</div>
        <button onClick={() => myPoints(point)}>hello</button>
        <Link to={"/login"}>login</Link>
    </div>
  )
}

export default Main