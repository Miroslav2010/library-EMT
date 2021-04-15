import React, { Component } from 'react'
import Books from '../Books/BooksList/Books';
import Header from '../Header/header'
import BookEdit from '../Books/BookEdit/bookEdit'
import Categories from '../Categories/Categories'
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import BookService from '../../repository/booksRepository';
import CategoriesService from '../../repository/categoriesRepository';
import BookAdd from '../Books/BookAdd/bookAdd'
import AuthorService from '../../repository/authorsRepository'

class App extends Component {
  render(){
    return (
      <div className="App">
      <Router>
        <Header />
        <main>
          <div>
            <Route path="/books" exact render={() => <Books books={this.state.books} onEdit={this.getBook} onDelete={this.deleteBook} markAsTaken={this.markAsTaken}/>} />
            <Route path="/categories" exact render={() => <Categories categories={this.state.categories} />} />
            <Route path="/book/add" exact render={() => 
              <BookAdd authors={this.state.authors} categories={this.state.categories} onAddBook={this.addBook}/>} />
            <Route path={"/book/edit/:id"} exact render={() => 
              <BookEdit authors={this.state.authors} book={this.state.selectedBook} categories={this.state.categories} onEditBook={this.editBook} />} />
          </div>
          <Redirect to={"/books"} />
        </main>
      </Router>
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

  loadCategories = () => {
    CategoriesService.fetchCategories().then((data) => {
      this.setState({
        categories : data.data
      })
    })
  }

  loadAuthors = () => {
    AuthorService.fetchAuthors().then((data) => {
      this.setState({
        authors: data.data
      })
    })
  }

  markAsTaken = (id) => {
    BookService.markAsTaken(id).then(() => {
      this.loadBooks()
    })
  }

  addBook = (name,author,category,availableCopies) => {
    BookService.addBook(name,author,availableCopies,category).then(() => {
      this.loadBooks()
    })
  }

  editBook = (id,name,author,category,availableCopies) => {
    BookService.editBook(id,name,author,availableCopies,category).then(() => {
      this.loadBooks()
    })
  }

  deleteBook = (id) => {
    BookService.deleteBook(id).then(() => {
      this.loadBooks();
    })
  }

  getBook = (id) => {
    BookService.getBook(id)
    .then((data) => {
      this.setState({selectedBook : data.data})
    })
  }

  componentDidMount(){
    this.loadBooks()
    this.loadCategories()
    this.loadAuthors()
  }

  constructor(props){
    super(props);
    this.state = {
      books : [],
      categories : [],
      authors: [],
      selectedBook: {}
    }
  }
}

export default App;
