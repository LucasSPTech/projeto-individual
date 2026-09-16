import style from "../styles/Cadastro.module.css";

function Cadastro({ irParaCatalogo }) {
  async function cadastrarViagem(event) {
    event.preventDefault();

    const form = event.target;
    const dados = new FormData(form);
    const viagem = {
      destination: dados.get("destination"),
      departure: dados.get("departure"),
      companions: dados.get("companions"),
      review: Number(dados.get("review")),
      memories: dados.get("memories"),
    };

    try {
      const resposta = await fetch("http://localhost:8080/travels", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(viagem),
      });

      if (!resposta.ok) {
        throw new Error("Erro ao cadastrar viagem");
      }

      const id = await resposta.json();
      console.log("Viagem cadastrada. ID:", id);
      alert("Viagem cadastrada com sucesso!");

      form.reset();
    } catch (erro) {
      console.error(erro);
      alert("Erro ao cadastrar viagem.");
    }
  }

  return (
    <div className={style.pai}>
      <div className="rounded border px-2 py-3 w-120">
        <div className="flex justify-between items-center  p-2">
          <h1 className="text-xl mb-2">Registre suas viagens</h1>
          <button onClick={irParaCatalogo} className="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 transition-colors">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="lucide lucide-book-open">
                <path d="M12 5v16" />
                <path d="M20.001 19A2 2 0 0022 17V5a2 2 0 00-1.999-2L16 3.002A5 5 0 0012 5a5 5 0 00-4-2H4a2 2 0 00-2 2v12a2 2 0 001.999 2H8a5 5 0 014 2 5 5 0 014-2z" />
            </svg>
          </button>
        </div>

        <div className="rounded px-3 py-4">
          <form onSubmit={cadastrarViagem} className="flex flex-col gap-3">
            <label htmlFor="ipt_destino">Destino:</label>
            <input type="text" name="destination" id="ipt_destino" placeholder="Local visitado..." className="rounded border p-1"/>

            <label htmlFor="ipt_ida">Data de Ida:</label>
            <input type="date" name="departure" id="ipt_ida"className="rounded border p-1"/>

            <label htmlFor="ipt_companheiros">Companheiros de Viagem:</label>
            <input type="text" name="companions" id="ipt_companheiros" placeholder="Companheiros de viagem..." className="rounded border p-1"/>

            <label htmlFor="slc_avaliacao">Avaliação</label>
            <select name="review" id="slc_avaliacao" className="rounded border p-1" defaultValue="0">
                <option value="0" disabled>Selecione uma nota...</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>

            <label htmlFor="txt_memorias">Memorias:</label>
            <textarea id="txt_memorias" name="memories" rows="4" className="rounded border p-1 resize-y min-h-20 max-h-50"/>

            <button type="submit" className="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 transition-colors ml-auto">
              Salvar Viagem
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Cadastro;