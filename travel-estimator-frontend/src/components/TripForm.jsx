import { useState } from "react";
import { calculateTripCost } from "../services/tripService";

const TripForm = ({ setTripData }) => {
    const [source, setSource] = useState("");
    const [destination, setDestination] = useState("");
    const [date, setDate] = useState("");
    
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const formattedDate = new Date(date).toISOString().split("T")[0];
            const result = await calculateTripCost(source,destination,date);
            setTripData(result);
        }
        catch (error) {
            alert("Failed to calculate trip cost. Check console for details.");
        }
    };

    return (
        <form onSubmit={handleSubmit} className="trip-form">
            <input type="text" placeholder="Source" value={source} onChange={(e) => setSource(e.target.value)} required />
            <input type="text" placeholder="Destination" value={destination} onChange={(e) => setDestination(e.target.value)} required />
            <input type="date" placeholder={date} onChange={(e) => setDate(e.target.value)} required />
            <button type="submit">Calculate Cost</button>
        </form>
    );    
};

export default TripForm;