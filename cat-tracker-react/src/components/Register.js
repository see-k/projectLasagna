import './../App.css';

import { useContext, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import AuthContext from './AuthContext';
import Errors from './Errors';

function Register() {
  const auth = useContext(AuthContext);

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState([]);

  const history = useHistory();

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/create_account', {
        method: 'POST',
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          username,
          password
        })
      });

      if (response.status === 201) {
        try {
          await auth.authenticate(username, password);
          history.push('/');
        }
        catch (err) {
          throw new Error('Unknown Error');
        }
      }
      else if (response.status === 400) {
        throw new Error('This username is already in use');
      }
      else {
        throw new Error('Unknown Error');
      }
    }
    catch (err) {
      setErrors([err.message]);
    }
  }

  return (
    <div className="container mt-5 ">
    <div className="row justify-content-md-center">
      <div className="col col-4">
        <div className="card text-center">
          <h2 className="card-header">Create an Account</h2>
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
                  <Link className="btn btn-danger ml-2 mx-2 mt-4 mb-4" to="/">Cancel</Link>
                  <button className="btn btn-success ml-2 mx-2 mt-4 mb-4" type="submit">Create Account</button>
                </div>
                <div>              
                  <Link className="btn btn-warning ml-2 mb-3" to="/login">Already have an account? Sign in.</Link>
                </div>
              </form>
            </div>
        </div>
      </div>
    </div>
  </div>
  );
}

export default Register;
