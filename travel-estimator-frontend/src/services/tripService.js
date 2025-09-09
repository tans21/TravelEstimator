import axios from "axios";

const API_URL = "http://localhost:8080/api/trips";

export const calculateTripCost = async (source, destination, date) => {
  try {
    console.log("Request Data:", { source, destination, date });

    const response = await axios.post(
      `${API_URL}/calculate`,
      null, // no body, since backend expects query params
      {
        params: { source, destination, date },
      }
    );

    console.log("Response Data:", response.data);
    return response.data;
  } catch (error) {
    console.error(
      "Error calculating trip cost:",
      error.response?.data || error.message
    );
    throw error;
  }
};
