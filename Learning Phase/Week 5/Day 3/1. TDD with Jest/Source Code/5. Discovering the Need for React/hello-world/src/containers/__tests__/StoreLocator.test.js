import React from 'react';
import {shallow} from 'enzyme';
import StoreLocator from '../StoreLocator';

// describe("StoreLocator", function(){

// let mountedStoreLocator;
// beforeEach(()=>{
//     mountedStoreLocator = shallow(<StoreLocator />);
// });

it('renders without crashing', () => {
    let mountedStoreLocator = shallow(<StoreLocator />);
    // const div = document.createElement('div');
    // ReactDOM.render(<StoreLocator />, div);

});

// it('renders a header', () => {
//     const headers = mountedStoreLocator.find('Header');
//     expect(headers.length).toBe(1);
// });

// it('renders two buttons', () => {
//     const buttons = mountedStoreLocator.find('Button');
//     expect(buttons.length).toBe(2);
// });

// it('renders a map', () => {
//     const maps = mountedStoreLocator.find('Map');
//     expect(maps.length).toBe(1);
// })
// });