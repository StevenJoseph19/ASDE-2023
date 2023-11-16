import React from "react";
import { shallow } from "enzyme";
import Button from "../Button";

describe("Button", function () {
  let mountedButton;

  beforeEach(() => {
    mountedButton = shallow(<Button />);
  });

  it("renders without crashing", () => {
    let mountedButton = shallow(<Button />);
  });

  it("renders a button", () => {
    const button = mountedButton.find("button");
    expect(button.length).toBe(1);
  });

  it("call a function passed to it when clicked", () => {
    const mockCallBack = jest.fn();
    const mountedButtonWithCallback = shallow(
      <Button handleClick={mockCallBack} />
    );
    mountedButtonWithCallback.find("button").simulate("click");
    expect(mockCallBack.mock.calls.length).toEqual(1);
  });
});

describe("When a location is passed to it", () => {
  let mountedButton;
  let props;

  beforeEach(() => {
    props = {
      location: "Location 1",
    };
    mountedButton = shallow(<Button {...props} />);
  });

  it("displays the location", () => {
    const locName = mountedButton.find(".location-button");
    expect(locName.text()).toEqual("Location 1");
  });
});

describe("When no location is passed to it", () => {
  let mountedButton;
  let props;

  beforeEach(() => {
    props = {
      location: "",
    };
    mountedButton = shallow(<Button {...props} />);
  });

  it("displays the default location", () => {
    const locName = mountedButton.find(".location-button");
    expect(locName.text()).toEqual("All Locations");
  });
});
