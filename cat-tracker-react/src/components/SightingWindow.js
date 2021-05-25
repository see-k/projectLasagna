import { Link } from 'react-router-dom';
import { formatRelative } from 'date-fns';

function SightingWindow({lat, lng, time, deleteMarker}) {
  return (
    <div>
        <h2>Add a new Sighting?</h2>
        <Link className="btn btn-secondary" to="/sighting/add">yes</Link>
        <button className="btn btn-secondary" onClick={deleteMarker}>no</button>
        {/*<p>Spotted {formatRelative(time, new Date())}</p>*/}
    </div>
  );
}

export default SightingWindow;
