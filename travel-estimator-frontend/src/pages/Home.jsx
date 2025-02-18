import { useState } from "react";
import TripForm  from "../components/TripForm";
import TripResult from "../components/TripResult";

const Home = () => {
    const [tripData, setTripData] = useState(null);

    return (
        <div className="home">
            <h1>Travel Estimator</h1>
            <TripForm setTripData={setTripData} />
            <TripResult tripData={tripData} />
        </div>
    );
};

export default Home;