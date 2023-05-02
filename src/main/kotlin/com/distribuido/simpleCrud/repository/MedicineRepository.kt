package com.distribuido.simpleCrud.repository

import Medicine
import org.springframework.data.cassandra.repository.CassandraRepository

interface MedicineRepository : CassandraRepository<Medicine, String>
