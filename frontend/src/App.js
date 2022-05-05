import logo from './logo.svg';
import './App.css';
import React, { Component } from "react";
import { menu } from "./menu";


class App extends Component {
  state = {
  categories: menu.menu.categories,
     menu: menu,
     cart : []
  };

//  async componentDidMount() {
//    const response = await fetch('menu',{headers:{
//                                                  "accepts":"application/json"
//                                              }});
//    const body = await response.json();
//    console.log(body.categories);
//    this.setState({categories : body.categories,menu: body});
//  }

  render() {
    //const {menu} = this.state;
    const categories = this.state.menu.menu.categories;
    const menu = this.state.menu.menu;
    console.log(categories);
    console.log(this.state);
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Menu</h2>
                 {{menu}.map(item =>
                                  <div key={menu.categories}>
                                    {menu.Burgers}
                                  </div>
                              )}
           </div>
          </header>
        </div>
    );
  }
}
export default App;
