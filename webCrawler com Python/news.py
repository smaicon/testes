
import feedparser
url_feed = "http%3A//feeds.folha.uol.com.br/folha/emcimadahora/rss091.xml"


feed = feedparser.parse(url_feed)
for post in feed.entries:
    print post.title, post.link

