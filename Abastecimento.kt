// Abastecimento
fun abastecimento() {
    println("\nAbastecimento")
    //Posto 1- Wayne
    println("--- Posto Wayne Oil ---")
    print("Preço do Álcool: ")
    val alcoolWayne = readln().toDoubleOrNull() ?: 0.0
    print("Preço da Gasolina: ")
    val gasolinaWayne = readln().toDoubleOrNull() ?: 0.0

    // Posto 2- Stark Petrol
    println("\n--- Posto Stark Petrol ---")
    print("Preço do Álcool: ")
    val alcoolStark = readln().toDoubleOrNull() ?: 0.0
    print("Preço da Gasolina: ")
    val gasolinaStark = readln().toDoubleOrNull() ?: 0.0

    val litrosTanque = 42

    // Álcool é vantajoso se for 30% mais barato (ou seja, até 70% do preço da gasolina)
    val combustivelWayne: String
    val precoWayne: Double
    if (alcoolWayne <= gasolinaWayne * 0.70) {
        combustivelWayne = "Álcool"
        precoWayne = alcoolWayne
    } else {
        combustivelWayne = "Gasolina"
        precoWayne = gasolinaWayne
    }
    val totalWayne = precoWayne * litrosTanque

    val combustivelStark: String
    val precoStark: Double
    if (alcoolStark <= gasolinaStark * 0.70) {
        combustivelStark = "Álcool"
        precoStark = alcoolStark
    } else {
        combustivelStark = "Gasolina"
        precoStark = gasolinaStark
    }
    val totalStark = precoStark * litrosTanque

    println("\nWayne Oil: melhor opção = %s | Total (42L) = R$ %.2f".format(combustivelWayne, totalWayne))
    println("Stark Petrol: melhor opção = %s | Total (42L) = R$ %.2f".format(combustivelStark, totalStark))

    val melhorPosto: String
    val melhorCombustivel: String

    if (totalWayne <= totalStark) {
        melhorPosto = "Wayne Oil"
        melhorCombustivel = combustivelWayne.lowercase()
    } else {
        melhorPosto = "Stark Petrol"
        melhorCombustivel = combustivelStark.lowercase()
    }

    println("\n%s, é mais barato abastecer com %s no posto %s.".format(nomeUsuario, melhorCombustivel, melhorPosto))
}
