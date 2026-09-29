// Ar-Condicionado
fun arCondiconado() {
    var empresaBarata = ""
    var menorValor = Double.MAX_VALUE
    var empresaCara = ""
    var maiorValor = 0.0

    var totalEmpresasCadastradas = 0
    var continuar = true

    println("Ar-Condicionado - Comparativo Técnico")
// 7.1 Parte A- Requisitod
    while (continuar) {
        println("Cadastro de Empresa")
        print("Nome da empresa: ")
        val nomeEmpresa = readln()

        print("Valor por aparelho (R\$): ")
        val valorPorAparelho = readln().toDoubleOrNull() ?: 0.0

        print("Quantidade de aparelhos: ")
        val qtdAparelho = readln().toIntOrNull() ?: 0

        print("Percentual de desconto (%): ")
        val porcentagemDesconto = readln().toDoubleOrNull() ?: 0.0

        print("Quantidade mínima para desconto: ")
        val qtdMinima = readln().toIntOrNull() ?: 0

        print("Valor fixo de deslocamento (R\$): ")
        val deslocamento = readln().toDoubleOrNull() ?: 0.0

        val valorTotal = calcularOrcamento(
            valorPorAparelho,
            qtdAparelho,
            porcentagemDesconto,
            qtdMinima,
            deslocamento
        )
        totalEmpresasCadastradas++

        if (totalEmpresasCadastradas == 1) {
            maiorValor = valorTotal
            empresaCara = nomeEmpresa
            menorValor = valorTotal
            empresaBarata = nomeEmpresa
        } else {
            if (valorTotal > maiorValor) {
                maiorValor = valorTotal
                empresaCara = nomeEmpresa
            }
            if (valorTotal < menorValor) {
                menorValor = valorTotal
                empresaBarata = nomeEmpresa
            }
        }

        println("O serviço de %s custará R$ %.2f".format(nomeEmpresa, valorTotal))

        print("\nDeseja informar novos dados? (S/N): ")
        var respostaContinuar = readln().uppercase().trim()

        while (respostaContinuar != "S" && respostaContinuar != "N") {
            print("Comando inválido. Digite S ou N: ")
            respostaContinuar = readln().uppercase().trim()
        }

        if (respostaContinuar == "N") {
            continuar = false
        }
    }

    if (totalEmpresasCadastradas >= 2) {
        val diferencaPercentual = ((maiorValor - menorValor) / menorValor) * 100

        println("\n-----------------Resumo Final -----------------")
        println("O orçamento de menor valor é o de %s por R$ %.2f".format(empresaBarata, menorValor))
        println("O orçamento de maior valor é o de %s por R$ %.2f".format(empresaCara, maiorValor))
        println("A diferença percentual entre melhor e pior proposta é de %.2f%%".format(diferencaPercentual))
        println("-----------------------------------------------")
    } else {
        println("\nÉ necessário informar ao menos duas empresas para exibir o comparativo final.")
    }
}

fun calcularOrcamento(
    valorAparelho: Double,
    quantidade: Int,
    percentualDesconto: Double,
    qtdMinimo: Int,
    deslocamento: Double
): Double {
    val brutoTotal = valorAparelho * quantidade

    var desconto = 0.0
    if (quantidade >= qtdMinimo) {
        desconto = brutoTotal * (percentualDesconto / 100.0)
    }
    val totalComDesconto = brutoTotal - desconto
    val totalComDeslocamento = totalComDesconto + deslocamento
    return totalComDeslocamento
}
