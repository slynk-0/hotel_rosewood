val nomeHotel: String = "hotel rosewood"

var totalReservasConfirmadas = 0
var quartosOcupados = 0
val ocupacaoQuartos = BooleanArray(21) { false }
var quantidadeHospedes = 0
var quantidadeEventos = 0

var receitaHospedagem = 0.0
var receitaEventos = 0.0

data class Hospede(
    var nome: String,
    val registro: String
)
val listaHospedes = mutableListOf<Hospede>()
var contadorOrdem = 1
var nomeUsuario: String = ""
