import tag as tag
from bs4 import BeautifulSoup
from pip._vendor import requests


def extract_title(content):
    soup = BeautifulSoup(content, "lxml")
    tag = tag = soup.find("title", text=True)

    if not tag:
        return None
    return tag.string.strip()
def extract_links(content):
    soup = BeautifulSoup(content, "lxml")
    links = set()
    for tag in soup.find_all("a", href=True):
        if tag["href"].startswith("http"):
            links.add(tag["href"])
    return links
#navegando sozinho
def crawl(start_url):
    seen_urls = set()
    avaiable_urls = set(start_url)

    while avaiable_urls:
        url = avaiable_urls.pop()

        try:
            content = requests.get(url, timeout=3).text
        except Exception:
            continue
        title = extract_title(content)

        if title:
            print(title)
            print(url)
            print()


        for link in extract_title(content):
            if link not in seen_urls:
                seen_urls.add(link)
                avaiable_urls.add(link)
try:
    crawl("https://www.python.org/")
except KeyboardInterrupt:
    print()
    print("bye")
