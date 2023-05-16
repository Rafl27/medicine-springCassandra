package com.distribuido.simpleCrud.repository

import com.distribuido.simpleCrud.entity.Medicine
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MedicineRepository : CassandraRepository<Medicine, String>
