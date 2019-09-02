package facades;

import dto.MovieDTO;
import entities.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade implements MovieFacadeInterface{

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public ArrayList<MovieDTO> getMovie(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT e FROM Movie e WHERE e.name = :name");
            q.setParameter("name", name);
            List list = new ArrayList<MovieDTO>();
            for (int i = 0; i < q.getResultList().size(); ++i) {
                list.add(new MovieDTO((Movie) q.getResultList().get(i)));
            }
            return (ArrayList<MovieDTO>) list;
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<MovieDTO> getAllMovies(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT e FROM Movie e");
            List list = new ArrayList<MovieDTO>();
            for (int i = 0; i < q.getResultList().size(); ++i) {
                list.add(new MovieDTO((Movie) q.getResultList().get(i)));
            }
            return (ArrayList<MovieDTO>) list;
        } finally {
            em.close();
        }
    }

    @Override
    public void createMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteMovie(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(Movie.class, id));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    


}
