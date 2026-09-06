import { useState } from 'react'
import Cadastro from './components/Cadastro'
import Catalogo from './components/Catalogo';

function App() {
  const [tela, setTela] = useState("cadastro");

  if (tela === "cadastro") {
    return <Cadastro />;
  } 

  if (tela === "catalogo") {
    return <Catalogo />
  }
}

export default App