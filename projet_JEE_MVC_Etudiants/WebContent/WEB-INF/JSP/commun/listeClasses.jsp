<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div class="row">
				<div class="col-md-1"></div>
				
				<!--  TOUT LE MONDE -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants">
						<input type="hidden" name="idEtudiant" value="all"/>
						<button type="submit" class="btn btn-default">
							Tous les poto
						</button>
					</form>
				</div>
				
				<!--  SIMO -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?classe=simo">
						<input type="hidden" name="idEtudiant" value="simo"/>
						<button type="submit" class="btn btn-primary">
							Belli-SIMO
						</button>
					</form>
				</div>
				
				<!--  BIG-DATA -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?classe=big-data">
						<input type="hidden" name="idEtudiant" value="big-data"/>
						<button type="submit" class="btn btn-success">
							BIG-D
						</button>
					</form>
				</div>
				
				<!--  MIAW -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?classe=miaw">
						<input type="hidden" name="idEtudiant" value="miaw"/>
						<button type="submit" class="btn btn-info">
							MIAOU
						</button>
					</form>
				</div>
				
				<!--  ASSR -->
				<div class="col-md-2">
					<form method="post" action="<%= getServletContext().getContextPath()%>/do/listeEtudiants?classe=assr">
						<input type="hidden" name="idEtudiant" value="assr"/>
						<button type="submit" class="btn btn-warning">
							Les autres là
						</button>
					</form>
				</div>
				
				<div class="col-md-1"></div>
		</div>