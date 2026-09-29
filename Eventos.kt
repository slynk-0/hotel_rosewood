//Eventos

fun eventos(): Double {
    // 6.1 Parte A- Capacidade e seleção de auditório
    println("Eventos")
    print("Informe o número de convidados: ")
    val convidados = readln().toIntOrNull() ?: -1

    if (convidados <= 0 || convidados > 350) {
        println("Número de convidados inválido.")
        return 0.0 }

    println("Número de convidados válido.")
    val auditorio: String
    var cadeiras_adicionais = 0

    if (convidados <= 220) {
        auditorio= "Laranja"
        if (convidados > 150) {
            cadeiras_adicionais = convidados - 150
            println("Auditório selecionado: $auditorio ($cadeiras_adicionais cadeiras adicionais)")
        } else {
            println("Auditório selecionado: $auditorio")
        }
    } else {
        auditorio = "Colorado"
        println("Auditório selecionado: $auditorio")
    }

    // 6.2 Parte B- Agenda e disponibilidade
    print("Informe o dia da semana (ex: segunda, terca, sexta): ")
    val dia = readln().lowercase().trim()

    val dias_Uteis = listOf("segunda", "terca", "terça", "quarta", "quinta", "sexta")
    val fimDeSemana = listOf("sabado", "sábado", "domingo")

    if (dia in dias_Uteis) {
        println("\n=======================================================")
        println(" TABELA DE HORÁRIOS DISPONÍVEIS - SEGUNDA A SEXTA (07h às 23h)")
        println("=======================================================")
        println("[07h] [08h] [09h] [10h] [11h] [12h] [13h] [14h]")
        println("[15h] [16h] [17h] [18h] [19h] [20h] [21h] [22h] [23h]")
        println("=======================================================")
    } else if (dia in fimDeSemana) {
        println("\n=======================================================")
        println(" TABELA DE HORÁRIOS DISPONÍVEIS - SÁBADO E DOMINGO (07h às 15h)")
        println("=======================================================")
        println("[07h] [08h] [09h] [10h] [11h] [12h] [13h] [14h] [15h]")
        println("=======================================================\n")
    } else {
        println("Dia da semana indisponível.")
        return 0.0
    }

    print("Informe o horário inicial do evento (07 a 23): ")
    val horaInicio = readln().toIntOrNull() ?: -1

    print("Informe a duração do evento em horas (1 a 12): ")
    val duracao = readln().toIntOrNull() ?: -1

    if (duracao !in 1..12) {
        println("Duração inválida. O Evento deve durar de 1 a 12 horas. ")
        return 0.0
    }

    val horaFim = horaInicio + duracao

    if (dia in dias_Uteis && (horaInicio < 7 || horaFim > 23)) {
        println("Auditório Indisponível. Para dias úteis, o evento deve iniciar a partir das 07h e encerrar até às 23h.")
        return 0.0
    } else if (dia in fimDeSemana && (horaInicio < 7 || horaFim > 15)) {
        println("Auditório indisponível. Para fins de semana, o evento deve iniciar a partir das 07h e encerrar até às 15h.")
        return 0.0
    }

    print("Qual o nome da empresa contratante: ")
    val nomeEmpresa = readln().trim()
    println("Auditório reservado.")

    // 6.3 Parte C- Equipe de garçons (Arredondamento para cimaa)
    val garconsBase = (convidados + 12 - 1) / 12
    val garconsReforco = duracao / 2
    val total_Garcons = garconsBase + garconsReforco
    val custoGarcons = total_Garcons * duracao * 10.50

    // 6.4 Parte D- Serviço de Buffet
    val quantidadeCafe = convidados * 0.2
    val custoCafe = quantidadeCafe * 0.80

    val quantidadeAgua = convidados * 0.5
    val custoAgua = quantidadeAgua * 0.40

    val quantidadeSalgados = convidados * 7
    val custoSalgados = quantidadeSalgados * 0.34

    val custoBuffet = custoCafe + custoAgua + custoSalgados
    val totalGeral = custoGarcons + custoBuffet

    //6.5 Parte E- Relatório Técnico
    println("\n----------------------------------------------------")
    println("  Relatório do Evento  ")
    println("Auditório: %s".format(if (cadeiras_adicionais > 0) "$auditorio ($cadeiras_adicionais cadeiras adicionais)" else auditorio))
    println("Empresa: %s".format(nomeEmpresa))
    println("Data/Hora: %s das %dhs às %dhs".format(dia, horaInicio, horaFim))
    println("Convidados: %d | Duração: %d horas".format(convidados, duracao))
    println("Garçons necessários: %d".format(total_Garcons))
    println("---------------------------------------------------")
    println("Custo com garçons: R$ %.2f".format(custoGarcons))
    println("Buffet - Café: %.1f L | Água: %.1f L | Salgados: %d un".format(quantidadeCafe, quantidadeAgua, quantidadeSalgados))
    println("Custo do buffet: R$ %.2f".format(custoBuffet))
    println("---------------------------------------------------")
    println("Total do Evento: R$ %.2f".format(totalGeral))
    println("----------------------------------------------------")

    // Decisão e confirmação de reserva
    print("Confirmar reserva? (S/N): ")
    var confirma = readln().uppercase().trim()

    while (confirma != "S" && confirma != "N") {
        print("Comando inválido. Digite S ou N: ")
        confirma = readln().uppercase().trim()
    }

    if (confirma == "S") {
        quantidadeEventos++
        receitaEventos += totalGeral
        println("Reserva efetuada com sucesso.")
        return totalGeral
    } else {
        println("Reserva não efetuada.")
        return 0.0
    }
}
