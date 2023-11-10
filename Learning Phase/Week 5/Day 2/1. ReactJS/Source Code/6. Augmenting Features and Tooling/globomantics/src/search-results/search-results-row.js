// import React from "react";
import { useHistory } from "react-router-dom";

const SearchResultsRow = ({ house }) => {
  const history = useHistory();

  const setActive = () => {
    history.push(`/house/${house.id}`);
  };

  return (
    <tr onClick={setActive}>
      <td>{house.address}</td>
      <td>{house.price}</td>
    </tr>
  );
};

export default SearchResultsRow;
