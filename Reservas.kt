// Reserva de quartos
fun reservaQuartos() {
    var menuPrincipal = true

    while (menuPrincipal) {
        if (quartosOcupados == 20) {
            println("Todos os quartos estão ocupados.")
            return
        }
        println("[Reservas]")
        print("Informe o valor da diária: ")
        val valorDiaria = readln().toDoubleOrNull() ?: -1.0

        print("Informe a quantidade de diárias (1-30): ")
        val qtdDiarias = readln().toIntOrNull() ?: -1

        // Validação das diárias de acordo com os requisitos
        if (valorDiaria <= 0 || qtdDiarias !in 1..30) {
            println("Valor Inválido")
            continue
        }

        print("Informe o nome do hóspede: ")
        val nomeHospede = readln().trim()

        print("Tipo de quarto (S/E/L): ")
        val tipoQuarto = readln().uppercase().trim()

        var fator = 1.00
        var nomeTipo = "Standard"
        if (tipoQuarto == "E") {
            fator = 1.35
            nomeTipo = "Executivo"
        } else if (tipoQuarto == "L") {
            fator = 1.65
            nomeTipo = "Luxo"
        }

        var quartoEscolhido = 0
        var quartoValido = false

        while (!quartoValido) {
            print("Escolha um quarto (1-20): ")
            quartoEscolhido = readln().toIntOrNull() ?: 0

            if (quartoEscolhido !in 1..20) {
                println("Número do quarto inválido. Escolha de 1 a 20.")
            } else if (ocupacaoQuartos[quartoEscolhido]) {
                println("Quarto já está ocupado")

                print("Quartos disponíveis: ")
                val livres = mutableListOf<Int>()
                for (i in 1..20) {
                    if (!ocupacaoQuartos[i]) {
                        livres.add(i)
                    }
                }
                println(livres.joinToString(", "))
            } else {
                quartoValido = true
            }
        }

        val subtotal = valorDiaria * qtdDiarias * fator
        val taxaServico = subtotal * 0.10
        val totalFinal = subtotal + taxaServico

        println("\nResumo:")
        println("Hóspede: %s".format(nomeHospede))
        println("Quarto: %d (%s)".format(quartoEscolhido, nomeTipo))
        println("Subtotal: R$ %.2f".format(subtotal))
        println("Taxa de serviço (10%%): R$ %.2f".format(taxaServico))
        println("Total: R$ %.2f".format(totalFinal))

        println("\n%s, confirma a reserva? (S/N): ".format(nomeHospede))
        var confirma = readln().uppercase().trim()

        while (confirma != "S" && confirma != "N") {
            print("Comando inválido. Digite S ou N: ")
            confirma = readln().uppercase().trim()
        }

        if (confirma == "S") {
            ocupacaoQuartos[quartoEscolhido] = true
            quartosOcupados++

            totalReservasConfirmadas++
            receitaHospedagem += totalFinal

            println("Reserva efetuada com sucesso!")
        } else {
            println("Reserva não efetuada.")
        }

        println("Mapa de Quartos (L - Livres e O - Ocupados")
        var quartoAtual = 1
        for (linha in 1..4) {
            val linhaQuartos = mutableListOf<String>()
            for (coluna in 1..5) {
                var status = "L"
                if (ocupacaoQuartos[quartoAtual]) {
                    status = "O"
                }
                linhaQuartos.add("%02d:%s".format(quartoAtual, status))
                quartoAtual++
            }
            println(linhaQuartos.joinToString("   "))
        }
        println("-----------------------------")

        print("\nDeseja fazer outra reserva? (S/N): ")
        var opcaoMenu = readln().uppercase().trim()
        while (opcaoMenu != "S" && opcaoMenu != "N") {
            print("Digite S ou N: ")
            opcaoMenu = readln().uppercase().trim()
        }
        if (opcaoMenu == "N") {
            menuPrincipal = false
        }
    }
}
