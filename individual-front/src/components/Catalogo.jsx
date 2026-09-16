import style from "../styles/Catalogo.module.css"

function Catalogo({ irParaCadastro, viagens }) {
    async function buscarViagem() {
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

            const viagens = await resposta.json();

            console.log("Viagens:", viagens);

        } catch (erro) {
            console.error(erro);
            alert("Erro ao buscar viagens.");
        }
    }

    return (
        <div className={style.pai} >
            <div className="rounded border px-2 py-3 w-120">
                <div className="flex justify-between items-center  p-2">
                    <h1 className="text-xl mb-2">Registre suas viagens</h1>
                    <button onClick={irParaCadastro} className="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 transition-colors">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="lucide lucide-square-pen">
                            <path d="M12 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7" />
                            <path d="M18.375 2.625a1 1 0 0 1 3 3l-9.013 9.014a2 2 0 0 1-.853.505l-2.873.84a.5.5 0 0 1-.62-.62l.84-2.873a2 2 0 0 1 .506-.852z" />
                        </svg>
                    </button>
                </div>

                <div className="px-3 py-4 flex flex-col gap-4 max-h-125 overflow-y-auto">
                    {viagens.map((viagem) => (
                        <div key={viagem.id} className="border rounded-xl p-5 bg-white">
                            <div className="flex justify-between items-start mb-4">
                                <div>
                                    <span className="text-sm text-gray-500">Destino</span>
                                    
                                    <h2 className="text-xl font-semibold text-gray-800">
                                        {viagem.destination}
                                    </h2>
                                </div>

                                <span className="font-medium">
                                    {viagem.review}/5
                                </span>
                            </div>

                            <div className="text-sm text-gray-600 mb-4">
                                <span>Data: {viagem.departure}</span><br />
                                <span>Companheiros: {viagem.companions}</span>
                            </div>

                            <div className="border-t pt-3">
                                <span className="text-sm text-gray-500 mb-1">Memórias</span><br />
                                <span className="text-gray-700">{viagem.memories}</span>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Catalogo;