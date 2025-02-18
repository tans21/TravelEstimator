import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Home } from "./pages/Home";

function App() {
  return (
    <Router>
      <Route>
        <Route path="/" element={<Home/>} />
      </Route>
    </Router>
  );
};

export default App;
