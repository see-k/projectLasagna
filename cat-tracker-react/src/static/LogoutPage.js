import { Link } from 'react-router-dom';

function LogoutPage() {
  return (
    <div className="App">
      <div className="container-flex mt-5">
        <div className="row justify-content-md-center">
          <div className="col">
            <div className="card text-center">
              <h2 className="card-header">Logout Successful</h2>
                <div className="card-body">
                  <ul>
                    <li>You have been successfully logged out ;( </li>
                    <li>
                      Was this a mistake? Log back in <Link to="/login">here</Link>
                    </li>
                  </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default LogoutPage;