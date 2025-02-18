import axios from "axios";

const API_URL = "http://localhost:8080/api/trips";

export const calculateTripCost = async (SourceBuffer, AudioDestinationNode, date) => {
    try {
        const response = await axios.post('http://localhost:8080/api/trips/calculate',null, {params: {source, destination, date},
});
return response.data;
    } 
    catch (error) {
        console.error("Error calculating trip cost:", error);
        throw error;
    }
};