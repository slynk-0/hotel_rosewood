fun main() {
    println("Bem-vindo(a) ao $nomeHotel!")
    print("Digite o nome de usuário: ")
    nomeUsuario = readln()

    var tentativasRestantes = 3
    var senhaCorreta = false

    while (tentativasRestantes > 0 && !senhaCorreta) {
        print("Digite a senha: ")
        val senhaDigitada = readln()

        if (senhaDigitada == "2678") {
            senhaCorreta = true
        } else {
            tentativasRestantes--
            if (tentativasRestantes > 0) {
                println("Senha incorreta!! Você ainda tem $tentativasRestantes tentativa(s).")
            } else {
                println("Acesso negado! Sistema bloqueado devido ao excesso de tentativas.")
            }
        }
    }

    if (senhaCorreta) {
        println("Bem-vindo ao $nomeHotel, $nomeUsuario. É um imenso prazer ter você por aqui!")
        inicio()
    }
}

fun inicio() {
    var continuar = true

    while (continuar) {
        println("\nMenu Principal")
        println("1. Reservas de Quartos")
        println("2. Cadastro de Hóspedes")
        println("3. Eventos")
        println("4. Ar-Condicionado")
        println("5. Abastecimento")
        println("6. Relatórios Operacionais")
        println("7. Sair")
        print("Escolha uma opção: ")
        val opcao = readln().toIntOrNull()

        when (opcao) {
            1 -> reservaQuartos()
            2 -> cadastrarHospedes()
            3 -> eventos()
            4 -> arCondiconado()
            5 -> abastecimento()
            6 -> relatorioOperacional()
            7 -> {
                if (sairHotel()) {
                    continuar = false
                }
            }
            else -> println("Opção inválida!")
        }
    }
}

fun sairHotel(): Boolean {
    print("Você deseja sair? (S/N): ")
    val resposta = readln().trim().uppercase()

    if (resposta == "S" || resposta == "SIM") {
        println("Muito obrigado e até logo!")
        return true
    }

    println("Voltando ao menu principal...")
    return false
}
