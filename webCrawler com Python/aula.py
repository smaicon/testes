import requests
from bs4 import BeautifulSoup

url ='http://www.sjc.sp.gov.br/secretarias/mobilidade_urbana/horario-e-itinerario.aspx?acao=p&opcao=1&txt='

r = requests.get(url)

print(r.text)