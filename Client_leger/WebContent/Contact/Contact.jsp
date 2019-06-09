<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Nous contacter</title>
</head>
<body>
	<%@include file="/Header/header.jsp"%>

	<div class="jumbotron jumbotron bg-transparent">
		<h1 class="display-4  text-center">Formulaire de contact</h1>
		<p class="lead  text-center">Si vous avez des questions, une
			demande sur nos offres, ou bien une demande de partenariat n'hesitez
			pas à nous contacter</p>
		<hr class="my-4">
		<p class="lead"></p>


		<form class="form-horizontal" role="form" method="post">
			<div class="col-lg-12">
				<div class="tableaudebord">


					<div class='container'>


						<div class='row'>
							<div class="col-lg-12">
								<div class="card">
									<div class="card-header"><h3>Vos informations</h3></div>
									<div class="card-body">
										<div class='row'>

											<div class="col-md-6">

												<div class="form-group">
													<div class="col-sm-8">
														<select id="inputState" name="civilite"
															class="form-control">
															<option selected>Civilité</option>
															<option>Monsieur</option>
															<option>Madame</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													
													<div class="col-sm-8">
														<input type="text" class="form-control" name="nom" placeholder="Nom"
															id="name"> <span class="erreur">${form.erreurs['nom']}</span>
													</div>
												</div>
												<div class="form-group">
													
													<div class="col-sm-8">
														<input type="text" class="form-control" name="prenom" placeholder="Prenom"
															id="prenom"> <span class="erreur">${form.erreurs['prenom']}</span>
													</div>
												</div>
												<div class="form-group">
												
													<div class="col-sm-8">
														<input type="email" class="form-control" name="email" placeholder="Email"
															id="email"> <span class="erreur">${form.erreurs['email']}</span>
													</div>
												</div>
												<div class="form-group">
												
													<div class="col-sm-8">
														<input type="number" class="form-control" name="tel" placeholder="Téléphone"
															id="tel">
													</div>
												</div>

											</div>


											<div class="col-md-6">


												<div class="form-group">

													
													<div class="col-sm-8">
														<input type="text" class="form-control" name="adresse" placeholder="Adresse"
															id="adresse">
													</div>
												</div>

												<div class="form-group">
													
													<div class="col-sm-8">
														<input type="number" class="form-control" name="cp" placeholder="Code Postal"
															id="cp">
													</div>
												</div>
												<div class="form-group">
													
													<div class="col-sm-8">
														<input type="text" name="ville" class="form-control" placeholder="Ville"
															id="ville">
													</div>
												</div>
												<div class="form-group">
													
													<div class="col-sm-8">
														<input type="text" class="form-control" name="pays" placeholder="Pays"
															id="pays">
													</div>
												</div>
												<!--</form>-->
											</div>
										</div>
									</div>
								</div>



								<div class='row'>
									<div class="col-lg-12">
										<br> <br>
										<div class="card">
											<div class="card-header"><h4>Votre préocupation</h4></div>
											<div class="card-body">

												<div class="row">
													<div class="col-md-8">
														<div class="col-sm-8">
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="sujet" id="gridRadios1" value="devenir client"
																	checked> <label class="form-check-label"
																	for="gridRadios1"> Devenir client </label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="sujet" id="gridRadios2"
																	value="prendre rendez-vous avec un conseiller">
																<label class="form-check-label" for="gridRadios2">
																	Prendre rendez-vous avec un conseiller </label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="sujet" id="gridRadios2"
																	value="obtenir des informations sur un produit ou un service">
																<label class="form-check-label" for="gridRadios3">
																	Obtenir des informations sur un produit ou un service </label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="sujet" id="gridRadios2"
																	value="exprimer une difficulté, une insatisfaction, un
																	désaccord">
																<label class="form-check-label" for="gridRadios4">
																	Exprimer une difficulté, une insatisfaction, un
																	désaccord </label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="sujet" id="gridRadios2" value="Autre motif">
																<label class="form-check-label" for="gridRadios5">
																	Autre motif </label>
															</div>
														</div>
													</div>
													<br> <br> <br>

													<div class="form-group col-md-4">
														<label for="exampleFormControlTextarea1">Votre
															message:</label>
														<textarea name="message" class="form-control"
															id="exampleFormControlTextarea1" rows="3"></textarea>
														<span class="erreur">${form.erreurs['message']}</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<br> <br>
								<div class="card">
									<div class="card-header"><h3>Vous répondre</h3></div>
									<div class="card-body">
										<div class="row px-0">
											<div class="col-md-3"><h5>Répondre :</h5></div>
											<div class="col-md-3"></div>
											<div class="col-sm-6">
												<div class="form-check">
													<input class="form-check-input" type="radio" name="reponse"
														id="gridRadios1" value=" par
														email" checked>
													<label class="form-check-label" for="gridRadios1">
														Par email </label>
												</div>
												<div class="form-check">
													<input class="form-check-input" type="radio" name="reponse"
														id="gridRadios2" value="par
														téléphone">
													<label class="form-check-label" for="gridRadios2">
														Par téléphone </label>
												</div>
											</div>
										</div>


									</div>
								</div>
								<br> <br> <br>
								<div class="row">
									<div class="col-lg-5"></div>
									<div class="col-lg-7">
										<div class="boutton">
											<button type="submit" name="submit"
												class="btn btn-primary btn-lg">Envoyer</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@include file="/footer.jsp"%>
</body>
</html>