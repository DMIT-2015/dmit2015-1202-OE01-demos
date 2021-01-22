package dmit2015.hr.repository;

import dmit2015.hr.entity.JobsEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@ApplicationScoped
public class JobRepository {

    @PersistenceContext // (name = "oracle-hr-jpa-pu")
    private EntityManager entityManager;

    public void createJob(JobsEntity newJob) {
        entityManager.persist(newJob);
    }

    public Optional<JobsEntity> findById(String id) {
        Optional<JobsEntity> optionalJobsEntity = Optional.empty();
        try {
            JobsEntity singleResult = entityManager.find(JobsEntity.class, id);
            if (singleResult != null) {
                optionalJobsEntity = Optional.of(singleResult);
            }
        } catch (Exception e) {
            // log exception message
        }
        return optionalJobsEntity;
    }


}
