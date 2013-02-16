import org.hibernate.cfg.AnnotationConfiguration
import entity.Book

/**
 * This is an adaptation of a demo found at
 * http://groovy.codehaus.org/Using+Hibernate+with+Groovy
 */
def configureHibernate() {
    def hibernateProps = [
            "hibernate.dialect": "org.hibernate.dialect.HSQLDialect",
            "hibernate.connection.driver_class": "org.hsqldb.jdbcDriver",
            "hibernate.connection.url": "jdbc:hsqldb:mem:demodb",
            "hibernate.connection.username": "sa",
            "hibernate.connection.password": "",
            "hibernate.connection.pool_size": "1",
            "hibernate.connection.autocommit": "true",
            "hibernate.cache.provider_class": "org.hibernate.cache.NoCacheProvider",
            "hibernate.hbm2ddl.auto": "create-drop",
            "hibernate.show_sql": "true",
            "hibernate.transaction.factory_class": "org.hibernate.transaction.JDBCTransactionFactory",
            "hibernate.current_session_context_class": "thread"
    ]

    def config = new AnnotationConfiguration()
    hibernateProps.each { k, v -> config.setProperty(k, v) }
    config.addAnnotatedClass(Book)
    return config
}

def populateDatabase(sessionFactory) {
    def session = sessionFactory.currentSession
    def tx = session.beginTransaction()
    session.save(new Book(author: 'Dierk et al', title: 'Groovy in Action'))
    session.save(new Book(author: 'Tarnowski', title: 'Developer Testing'))
    tx.commit()
}

// Entry point
def sessionFactory = configureHibernate().buildSessionFactory()
populateDatabase(sessionFactory)

session = sessionFactory.currentSession
tx = session.beginTransaction()
def books = session.createQuery("from Book").list()
println 'Found ' + books.size() + ' books:'
books.each { println it }
tx.commit()