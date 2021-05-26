import './../App.css';

import { useContext, useState } from 'react';
import { Link, useHistory, useLocation } from 'react-router-dom';
import AuthContext from './AuthContext';
import Errors from './Errors'; 

function Login() {
  const auth = useContext(AuthContext);

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState([]);

  const history = useHistory();
  const location = useLocation();

  const { state: { from } = { from : '/' } } = location;

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      await auth.authenticate(username, password);
      history.push(from);
    }
    catch (err) {
      setErrors([err.message]);
    }
  }

  return (
    <div className="container-flex mt-5 ">
      <div className="row justify-content-md-center">
        <div className="col">
          <div className="card text-center">
            <h2 className="card-header">Login</h2>
              <Errors errors={errors} />
              <div className="card-body">
                <form onSubmit={handleSubmit}>
                  <div>
                    <div>
                      <label>Username:</label>
                    </div>
                      <input type="text" onChange={(event) => setUsername(event.target.value)} />
                  </div>
                  <div>
                    <div>
                      <label>Password:</label>
                    </div>
                      <input type="password" onChange={(event) => setPassword(event.target.value)} />
                  </div>
                  <div>
                    <Link className="btn btn-danger ml-2 mx-2 mt-4 mb-4" to={from}>Cancel</Link>
                    <button className="btn btn-success ml-2 mx-2 mt-4 mb-4" type="submit">Login</button>
                  </div>
                  <div>              
                    <Link className="btn btn-warning ml-2 mb-3" to="/register">I don't have an account</Link>
                  </div>
                </form>
              </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;