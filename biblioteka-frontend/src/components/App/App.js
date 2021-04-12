import './App.css';
import React, { Component } from 'react'
import Books from '../Books/Books';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import BookService from '../../repository/booksRepository';

class App extends Component {
  render(){
    return (
      <div className="App">
        <h1>Library application</h1>
        <Books books={this.state.books} />
      </div>
    )
  }

  loadBooks = () => {
    BookService.fetchBooks().then((data) => {
      this.setState({
        books : data.data
      })
    });
  }

  componentDidMount(){
    this.loadBooks()
  }

  constructor(props){
    super(props);
    this.state = {
      books : []
    }
  }
}

export default App;
