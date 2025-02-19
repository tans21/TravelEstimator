import axios from "axios";

const API_URL = "http://localhost:8080/api/trips"; 

// export const calculateTripCost = async (source, destination, date) => {
//   try {
//     const response = await axios.post(`${API_URL}/calculate`, { source, destination, date });
//     return response.data; 
//   } catch (error) {
//     console.error("Error calculating trip cost:", error); 
//     throw error; 
//   }
// };

// debugging 
// adding a console.log statement before making the request

export const calculateTripCost = async (source, destination, date) => {
  try {
    console.log("Request Data:", { source, destination, date }); // Debugging

    const response = await axios.post(
      `http://localhost:8080/api/trips/calculate`,
      null,  // No body needed for query parameters
      {
        params: { source, destination, date }, // Send data as query parameters
      }
    );

    console.log("Response Data:", response.data); // Debugging
    return response.data;
  } catch (error) {
    console.error("Error calculating trip cost:", error.response?.data || error.message);
    throw error;
  }
};

