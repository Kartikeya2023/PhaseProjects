import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './styles.css';
import back from './media/back.gif';


const PokemonList = () => {
  const [pokemonList, setPokemonList] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(0);
  const [selectedPokemon, setSelectedPokemon] = useState(null);
  const [showModal, setShowModal] = useState(false);

  const pageSize = 20;
  const apiUrl = 'https://pokeapi.co/api/v2/pokemon';
  const pokemonDetailsUrl = 'https://pokeapi.co/api/v2/pokemon/';

  useEffect(() => {
    fetchData();
  }, [currentPage]);

  const fetchData = async () => {
    try {
      const response = await axios.get(apiUrl, {
        params: {
          limit: pageSize,
          offset: (currentPage - 1) * pageSize,
        },
      });
      setTotalPages(Math.ceil(response.data.count / pageSize));
      setPokemonList(response.data.results);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const handleSearch = (event) => {
    const query = event.target.value.toLowerCase();
    setSearchQuery(query);
    setCurrentPage(1); // Reset pagination when searching
  };

  const filteredPokemonList = pokemonList.filter((pokemon) =>
    pokemon.name.includes(searchQuery.toLowerCase())
  );

  const handlePagination = (page) => {
    setCurrentPage(page);
    setSelectedPokemon(null); // Reset selected Pokemon when changing pages
    setShowModal(false); // Close the modal when changing pages
  };

  const handlePokemonClick = async (url) => {
    try {
      const response = await axios.get(url);
      setSelectedPokemon(response.data);
      setShowModal(true);
    } catch (error) {
      console.error('Error fetching Pokémon details:', error);
    }
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };

  return (
    <div>
      <div className="header">
     
        <h1>Pokémon List</h1>
      </div>
      <div className="search-container">
        <input
          type="text"
          value={searchQuery}
          onChange={handleSearch}
          placeholder="Search Pokémon"
          className="search-input"
        />
        <button className="search-button" onClick={handleSearch}>
          Search
        </button>
      </div>
      <div className="cards-container">
        {filteredPokemonList.map((pokemon) => (
          <div
            key={pokemon.name}
            className="card"
            onClick={() => handlePokemonClick(pokemonDetailsUrl + getPokemonId(pokemon.url))}
          >
            <h2>{pokemon.name}</h2>
            <img
              src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getPokemonId(
                pokemon.url
              )}.png`}
              alt={pokemon.name}
            />
          </div>
        ))}
      </div>
      {showModal && selectedPokemon && (
        <div className="modal">
          <div className="modal-content">
            <h2>{selectedPokemon.name}</h2>
            <img
              src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${selectedPokemon.id}.png`}
              alt={selectedPokemon.name}
              className="modal-image"
            />
            <div className="details">
              <p>Height: {selectedPokemon.height / 10} m</p>
              <p>Weight: {selectedPokemon.weight / 10} kg</p>
              {selectedPokemon.stats.map((stat) => (
                <p key={stat.stat.name}>
                  {stat.stat.name}: {stat.base_stat}
                </p>
              ))}
            </div>
            <button className="modal-close-button" onClick={handleCloseModal}>
              Close
            </button>
          </div>
        </div>
      )}
      <div className="pagination">
        {Array.from({ length: 30 }, (_, index) => index + 1).map((page) => (
          <button
            key={page}
            onClick={() => handlePagination(page)}
            className={currentPage === page ? 'active' : ''}
          >
            {page}
          </button>
        ))}
      </div>
    </div>
  );
};

const getPokemonId = (url) => {
  const parts = url.split('/');
  return parts[parts.length - 2];
};

export default PokemonList;
