import logo from './logo.svg';
import {idCheck} from './axios/userApi'
import './App.css';

function App() {

  const check = async(dto) => {
    let data = await idCheck(dto);
    console.log(data);
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <button onClick={() => check({membId:"asw11wsa"})}>test</button>
      </header>
    </div>
  );
}

export default App;
