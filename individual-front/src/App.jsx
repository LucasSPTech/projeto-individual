import { useState } from 'react'
import Cadastro from './components/Cadastro'
import Catalogo from './components/Catalogo';

function App() {
  const [tela, setTela] = useState("cadastro");
  const [viagens, setViagens] = useState([]);

  async function abrirCatalogo() {
    try {
      const resposta = await fetch("http://localhost:8080/travels", {
        method: "GET",
        headers: {
          "Content-Type": "application/json"
        }
      });

      if (!resposta.ok) {
        throw new Error("Erro ao buscar viagens");
      }

      const dados = await resposta.json();

      setViagens(dados);
      setTela("catalogo");

    } catch (erro) {
      console.error(erro);
      alert("Erro ao buscar viagens.");
    }
  }

  if (tela === "cadastro") {
    return <Cadastro irParaCatalogo={abrirCatalogo} />;
  }

  if (tela === "catalogo") {
    return <Catalogo irParaCadastro={() => setTela("cadastro")} viagens={viagens} />
  }
}

export default App