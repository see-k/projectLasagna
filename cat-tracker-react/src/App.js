import './App.css';
import logo from './cattrackerlogo.png';
import { useState, useEffect} from 'react';
import jwt_decode from 'jwt-decode';

import Nav from './components/Nav';
import Home from './components/Home';
import About from './static/About';
import Contact from './static/Contact';
import{ BrowserRouter as Router, Switch, Route, Link, Redirect } from 'react-router-dom';

import Login from './components/Login';
import NotFound from './static/NotFound';
import Register from './components/Register';
import AuthContext from './components/AuthContext';
import SightingsMap from './components/SightingsMap';
import SightingList from './components/SightingList';
import CatProfile from './components/CatProfile';

function App() {
  const [user, setUser] = useState(null);

  const login = (token) => {
    const { id, sub: username, roles: rolesString } = jwt_decode(token);
    const roles = rolesString.split(',');

    const user = {
      id,
      username,
      roles,
      token,
      hasRole(role) {
        return this.roles.includes(role);
      },
      isValid() {
        return true;
      }
    }

    setUser(user);
  }

  const authenticate = async (username, password) => {
    const response = await fetch('http://localhost:5000/authenticate', {
      method: 'POST',
      headers : {
        "content-type": "application/json"
      },
      body: JSON.stringify({
        username,
        password
      })
    });

    if (response.status === 200) {
      const { jwt_token } = await response.json();
      login(jwt_token);
    } else if (response.status === 403) {
      throw new Error('Bad username or password');
    } else {
      throw new Error('There was a problem logging in...')
    }
  }

  const logout = () => {
    setUser(null);
  }

  const auth = {
    user,
    authenticate,
    logout
  }

  return (
    <div className="App">
      <AuthContext.Provider value={auth}>
        <Router>
          <ul className="nav-links">
              
              <li>
                <Link className="link" to="/" href="#" >
                  <img src={logo} alt="Logo"/>
                </Link>
              </li>
              <li>
                <Link className="link" to="/cats" href="#">Cat Profiles</Link>
              </li>
              <li>
                <Link className="link" to="/sightings" href="#">Sightings</Link>
              </li>
              
              <Link className="link" to="/faq" href="#">FAQs</Link>
              <Link className="link" to="/about" href="#">About Us</Link>
              <Link className="link" to="/contact" href="#">Contact Us</Link>
              <Link className="btn btn-primary" to="/login">Log In</Link>
              <button className="btn btn-primary" onClick={logout}>Log Out</button>
          </ul>

          <Switch>
            <Route exact path="/">
            {(user && user.isValid()) ? (
                <Home />
              ) : (
                <Redirect to="/login" />
              )}
            </Route>
            <Route exact path="/sightings">
              <SightingList />
            </Route>
            <Route exact path="/cats">
              <CatProfile />
            </Route>
            <Route exact path="/map">
              <SightingsMap />
            </Route>
            <Route exact path="/login">
              <Login />
            </Route>
            <Route exact path="/register">
              <Register />
            </Route>
            <Route exact path="*">
              <NotFound />
            </Route>
          </Switch>
        </Router>
      </AuthContext.Provider>
    </div>
  );
}

export default App;
