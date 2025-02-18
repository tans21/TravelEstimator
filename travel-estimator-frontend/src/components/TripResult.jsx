const TripResult = ({ tripData }) => {
    if (!tripData) return null;

    return (
        <div className="trip-result">
            <h2>Trip Details</h2>
            <p><strong>From:</strong>{tripData.source}</p>
            <p><strong>To:</strong>{tripData.destination}</p>
            <p><strong>Distance:</strong>{tripData.distance} km</p>
            <p><strong>Estimated Cost:</strong>₹{tripData.estimatedCost}</p>
            <p><strong>Date:</strong>{tripData.tripDate}</p>
        </div>
    );
};

export default TripResult;