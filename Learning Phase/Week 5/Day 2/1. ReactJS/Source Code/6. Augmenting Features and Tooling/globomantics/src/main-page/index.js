import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import "./main-page.css";
import Header from "./header";
import FeaturedHouse from "./featured-house";
import SearchResults from "../search-results";
import HouseFilter from "./house-filter";
import HouseFromQuery from "../house/HouseFromQuery";
import useHouses from "../hooks/useHouses";
import useFeaturedHouse from "../hooks/useFeaturedHouse";
import HousesContext from "../context/housesContext";

function App() {
  // load data
  const allHouses = useHouses();
  const featuredHouse = useFeaturedHouse(allHouses);

  return (
    <Router>
      <HousesContext.Provider value={allHouses}>
        <div className="container">
          <Header subtitle="Providing houses all over the world" />
          <HouseFilter />
          <Switch>
            <Route path="/searchresults/:country">
              <SearchResults />
            </Route>
            <Route path="/house/:id">
              <HouseFromQuery />
            </Route>
            <Route path="/">
              <FeaturedHouse house={featuredHouse}></FeaturedHouse>
            </Route>
          </Switch>
        </div>
      </HousesContext.Provider>
    </Router>
  );
}

export default App;
