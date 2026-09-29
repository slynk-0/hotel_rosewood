// Cadastro
fun cadastrarHospedes() {
    while (true) {
        println("""
             [Cadastro de Hóspedes]
            1. Cadastrar
            2. Pesquisar por nome exato
            3. Pesquisar por prefixo
            4. Listar hóspedes (A-Z)
            5. Atualizar cadastro
            6. Remover cadastro
            7. Voltar ao Menu Principal
            Escolha uma opção: """.trimIndent())

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> { // Cadastrar Hospede
                if (listaHospedes.size >= 15) {
                    println("Máximo de cadastros atingido")
                } else {
                    print("Nome do hóspede: ")
                    val nome = readln().trim()

                    if (nome.isBlank()) {
                        println("Valor inválido.")
                    } else if (listaHospedes.any { hospede -> hospede.nome.equals(nome, ignoreCase = true) }) {
                        println("Hóspede já cadastrado")
                    } else {
                        val marcaReg = "Hóspede nº %d".format(contadorOrdem++)
                        listaHospedes.add(Hospede(nome, marcaReg))
                        quantidadeHospedes++
                        println("Hóspede cadastrado com sucesso.")
                    }
                }
            }
            2 -> { // Pesquisar pelo nome
                print("Informe o nome completo do hóspede: ")
                val nomeBusca = readln().trim()
                var encontrado: Hospede? = null
                for (hospede in listaHospedes) {
                    if (hospede.nome.equals(nomeBusca, ignoreCase = true)) {
                        encontrado = hospede
                        break
                    }
                }

                if (encontrado != null) {
                    println("Hóspede %s foi encontrado.".format(encontrado.nome))
                } else {
                    println("Hóspede não encontrado")
                }
            }
            3 -> { // Pesquisar pelo prefixo
                print("Informe o Prefixo do nome: ")
                val prefixo = readln().trim()

                if (prefixo.isBlank()) {
                    println("Valor inválido.")
                } else {
                    val resultados = mutableListOf<Hospede>()
                    for (hospede in listaHospedes) {
                        if (hospede.nome.startsWith(prefixo, ignoreCase = true)) {
                            resultados.add(hospede)
                        }
                    }

                    if (resultados.isNotEmpty()) {
                        println("Resultados:")
                        resultados.forEachIndexed { index, h ->
                            println("[%d] %s".format(index + 1, h.nome))
                        }
                    } else {
                        println("Hóspede não encontrado.")
                    }
                }
            }
            4 -> {
                if (listaHospedes.isEmpty()) {
                    println("Não há hóspedes cadastrados.")
                } else {
                    println("\n--- [Lista de Hóspedes (A-Z)] ---")
                    val listaOrdenada = listaHospedes.sortedBy { it.nome }
                    listaOrdenada.forEachIndexed { index, h ->
                        println("[%d] %s (%s)".format(index + 1, h.nome, h.registro))
                    }
                }
            }
            5 -> {
                if (listaHospedes.isEmpty()) {
                    println("Não há hóspedes para atualizar.")
                } else {
                    println("\n--- [Atualizar Cadastro] ---")
                    val listaOrdenada = listaHospedes.sortedBy { it.nome }
                    listaOrdenada.forEachIndexed { index, h ->
                        println("[%d] %s".format(index + 1, h.nome))
                    }

                    print("Digite o número do hóspede que deseja atualizar: ")
                    val indice = readln().toIntOrNull()

                    if (indice != null && indice in 1..listaOrdenada.size) {
                        val hospedeOriginal = listaOrdenada[indice - 1]
                        print("Novo nome: ")
                        val novoNome = readln().trim()

                        if (novoNome.isNotBlank()) {
                            val indexReal = listaHospedes.indexOf(hospedeOriginal)
                            listaHospedes[indexReal].nome = novoNome
                            println("Operação realizada com sucesso")
                        } else {
                            println("Nome inválido.")
                        }
                    } else {
                        println("Índice inválido.")
                    }
                }
            }
            6 -> {
                if (listaHospedes.isEmpty()) {
                    println("Não há hóspedes para remover.")
                } else {
                    println("\n--- [Remover Cadastro] ---")
                    val listaOrdenada = listaHospedes.sortedBy { it.nome }
                    listaOrdenada.forEachIndexed { index, h ->
                        println("[%d] %s".format(index + 1, h.nome))
                    }

                    print("Digite o número do hóspede que deseja remover: ")
                    val indice = readln().toIntOrNull()

                    if (indice != null && indice in 1..listaOrdenada.size) {
                        val hospedeParaRemover = listaOrdenada[indice - 1]
                        listaHospedes.remove(hospedeParaRemover)
                        quantidadeHospedes--
                        println("Operação realizada com sucesso")
                    } else {
                        println("Índice inválido.")
                    }
                }
            }
            7 -> {
                println("Voltando ao menu principal...")
                return
            }
            else -> {
                println("Opção inválida!")
            }
        }
    }
}
