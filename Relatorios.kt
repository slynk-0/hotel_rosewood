//Relatórios Operacionais
fun relatorioOperacional() {

    val taxaOcupacao = (quartosOcupados.toDouble() / 20.0) * 100
    val receitaTotalGeral = receitaHospedagem + receitaEventos

    println("--------RELATÓRIO OPERACIONAL DO $nomeHotel--------")
    println("Total de reservas de quartos confirmadas: $totalReservasConfirmadas")
    println(
        "Taxa de ocupação atual: %.2f%% (%d/20 quartos)"
            .format(taxaOcupacao, quartosOcupados)
    )

    println("Quantidade de hóspedes cadastrados: $quantidadeHospedes")
    println("Quantidade de eventos confirmados: $quantidadeEventos")
    println("----------------------------------------------")
    println("RECEITA ACUMULADA")
    println("----------------------------------------------")
    println("Hospedagem: R$ %.2f".format(receitaHospedagem))
    println("Eventos:    R$ %.2f".format(receitaEventos))
    println("----------------------------------------------")
    println("Total geral: R$ %.2f".format(receitaTotalGeral))
    println("\n")
}
