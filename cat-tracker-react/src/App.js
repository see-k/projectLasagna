import './App.css';
import logo from './cat-tracker-logo-small.png';
import 'bootswatch/dist/slate/bootstrap.min.css'; // Added this :boo
import { useState, useEffect} from 'react';
import jwt_decode from 'jwt-decode';

import Home from './components/Home';
import FAQ from './static/FAQ';
import About from './static/About';
import Contact from './static/Contact';
import{ BrowserRouter as Router, Switch, Route, Link, Redirect } from 'react-router-dom';

import Login from './components/Login';
import LogoutPage from './static/LogoutPage';
import NotFound from './static/NotFound';
import Register from './components/Register';
import AuthContext from './components/AuthContext';
import SightingsMap from './components/SightingsMap';
import SightingList from './components/SightingList';
import CatProfile from './components/CatProfile';
import UpdateSighting from './components/UpdateSighting';
import Sighting from './components/Sighting';

function App() {
  const [user, setUser] = useState(null);
  let loginMsg = '';

  const login = (token) => {
    const { id, sub: username, authorities: rolesString } = jwt_decode(token);
    const roles = rolesString.split(',');

    const user = {
      id, username, roles, token,
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
    const response = await fetch('http://localhost:8080/authenticate', {
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        username, password
      })
    });

    if (response.status === 200) {
      const { jwt_token } = await response.json();
      login(jwt_token);
    }
    else if (response.status === 403) {
      throw new Error('Bad username or password');
    }
    else {
      throw new Error('There was a problem logging in');
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

  if (user === null) {
    loginMsg = "Not logged in";
  }
  else {
    loginMsg = `Logged in as: ${user.username}`
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
              {(user && user.isValid()) ? ( 
                <li>
                  <Link className="link" to="/cats" href="#">Cat Profiles</Link>
                </li>
              ) : null }
              {(user && user.isValid()) ? ( 
                <li>
                  <Link className="link" to="/sighting-map" href="#">Sightings</Link>
                </li>
              ) : null }

              <Link className="link" to="/faq" href="#">FAQs</Link>
              <Link className="link" to="/about" href="#">About Us</Link>
              <Link className="link" to="/contact" href="#">Contact Us</Link>

              {(user && user.isValid()) ? ( 
                <h4> {loginMsg}</h4>
               ) : null }

              { !user ? ( 
                <Link className="btn btn-primary" to="/login">Log In</Link>
              ) : null}
              
              
              {(user && user.isValid()) ? ( 
                <Link className="btn btn-primary" to="/logout" onClick={logout}>Log Out</Link>

               ) : null }

          </ul>

          <Switch>
            <Route exact path="/">
            {(user && user.isValid()) ? (
                <Home />
              ) : (
                <Redirect to="/login" />
              )}
            </Route>
            <Route exact path="/faq">
                <FAQ />
            </Route>
            <Route exact path="/about">
                <About />
            </Route>
            <Route exact path="/contact">
                <Contact />
            </Route>
            <Route exact path="/sightings">
              <SightingList />
            </Route>
            <Route exact path="/cats">
              <CatProfile />
            </Route>
            <Route exact path="/sighting-map">
            {/* {(user && user.isValid()) ? ( */}
                <SightingsMap />
              {/* ) : (
                <Redirect to="/login" />
              )} */}
            </Route>
            <Route exact path="/sighting-list/cat/:id">
              <SightingList />

            </Route>
            <Route exact path="/sightings/edit/:sightingId">
              <UpdateSighting />
            </Route>
            <Route exact path="/sightings/:id">
              <Sighting />
            </Route>
            <Route exact path="/login">
              <Login />
            </Route>
            <Route path="/logout">
            <LogoutPage />
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
